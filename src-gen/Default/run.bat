echo SELECT 'CREATE DATABASE ticketingsystem_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_default') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/ticketingsystem_product_default"

java -cp ticketingsystem.product.default --module-path ticketingsystem.product.default -m ticketingsystem.product.default