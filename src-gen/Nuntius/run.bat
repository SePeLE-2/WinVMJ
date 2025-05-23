echo SELECT 'CREATE DATABASE ticketingsystem_product_nuntius' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ticketingsystem_product_nuntius') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/ticketingsystem_product_nuntius"

java -cp ticketingsystem.product.nuntius --module-path ticketingsystem.product.nuntius -m ticketingsystem.product.nuntius