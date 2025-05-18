echo SELECT 'CREATE DATABASE ticketingsystem_product_fivestar' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_fivestar') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/ticketingsystem_product_fivestar"

java -cp ticketingsystem.product.fivestar --module-path ticketingsystem.product.fivestar -m ticketingsystem.product.fivestar