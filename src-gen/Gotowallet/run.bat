echo SELECT 'CREATE DATABASE ticketingsystem_product_gotowallet' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_gotowallet') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/ticketingsystem_product_gotowallet"

java -cp ticketingsystem.product.gotowallet --module-path ticketingsystem.product.gotowallet -m ticketingsystem.product.gotowallet