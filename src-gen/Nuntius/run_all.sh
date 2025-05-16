#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE ticketingsystem_product_nuntius' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_nuntius') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/ticketingsystem_product_nuntius"
done

java -cp ticketingsystem.product.nuntius --module-path ticketingsystem.product.nuntius -m ticketingsystem.product.nuntius &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait