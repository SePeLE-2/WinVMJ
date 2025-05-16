#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE ticketingsystem_product_houseofcards' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_houseofcards') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/ticketingsystem_product_houseofcards"
done

java -cp ticketingsystem.product.houseofcards --module-path ticketingsystem.product.houseofcards -m ticketingsystem.product.houseofcards &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait