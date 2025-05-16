echo SELECT 'CREATE DATABASE ticketingsystem_product_houseofcards' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_houseofcards') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/ticketingsystem_product_houseofcards"

java -cp ticketingsystem.product.houseofcards --module-path ticketingsystem.product.houseofcards -m ticketingsystem.product.houseofcards