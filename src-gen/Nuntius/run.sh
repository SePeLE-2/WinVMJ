#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp ticketingsystem.product.nuntius --module-path ticketingsystem.product.nuntius -m ticketingsystem.product.nuntius 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE ticketingsystem_product_nuntius' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_nuntius') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/ticketingsystem_product_nuntius"
done

wait