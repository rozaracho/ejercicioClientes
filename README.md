# ejercicioClientes

Se crea aplicación para leer csv de clientes y ser guardados

1. Para importar el archivo
Crear cvs con datos, por ejemplo

ID,Nombre,Email
1,Ana García,ana@example.com
2,Juan Pérez,juan@example.com
3,Maria López,maria@example.com
4,Carlos Martinez,carlos@example.com
5,Laura Rodriguez,laura@example.com

Importar el archivo desde postman - Ejemplo

curl --location 'http://localhost:8080/api/csv/upload' \
--form 'file=@"/C:/Users/zarac/Downloads/clientes.csv"'

2. para consultar los usuarios guardados, ejecultar

curl --location 'http://localhost:8080/api/clientes'