echo SELECT 'CREATE DATABASE ticketingsystem_product_ticketingsystem' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_ticketingsystem') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/ticketingsystem_product_ticketingsystem"

java -cp ticketingsystem.product.ticketingsystem --module-path ticketingsystem.product.ticketingsystem -m ticketingsystem.product.ticketingsystem