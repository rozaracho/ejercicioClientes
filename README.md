# ejercicioClientes

Se crea aplicación para leer csv de clientes y ser guardados

1. Para importar el archivo csv

Importar el archivo desde postman - Ejemplo

curl --location 'http://localhost:8080/api/csv/upload' \
--form 'file=@"/C:/Users/zarac/Downloads/clientes.csv"'

2. para consultar los usuarios guardados, ejecultar

curl --location 'http://localhost:8080/api/clientes'
