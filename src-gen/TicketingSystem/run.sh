#!/bin/bash
# source ~/.zshrc  
source ~/.bashrc

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp ticketingsystem.product.ticketingsystem --module-path ticketingsystem.product.ticketingsystem -m ticketingsystem.product.ticketingsystem 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE ticketingsystem_product_ticketingsystem' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_ticketingsystem') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/ticketingsystem_product_ticketingsystem"
done

wait