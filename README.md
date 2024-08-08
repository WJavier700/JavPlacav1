<h1>Requerimiento</h1>
<p>En respuesta a la creciente congestión vehicular en la ciudad, el municipio ha implementado el sistema de Pico y Placa para vehículos particulares
Necesitamos que desarrollen un programa que determine si un vehículo puede circular en una hora y fecha específicas, tomando en cuenta las reglas de Pico y Placa vigentes.</p>

<b>Requisitos:<b>
<br>
Entrada de Datos: <br>
Placa del vehículo <br>
Hora<br>
Fecha<br><br>
Salida:<br>
Información sobre si el vehículo puede o no circular en el momento especificado.<br>
Almacenamiento de Datos:<br>
La información resultante de cada consulta debe ser almacenada en una base de datos SQL Server.
<hr>
<h2>Solucion</h2>
Para la construccion del codigo se utilizo Java, con conexion a SQL usando el patrón de diseño orientado a objeto MVC, se uso excepciones para el control de la conexion con la base de datos y sentencias de control para validar el ingreso de la placa.
Tambien se implemento una estructura de datos que almacena las restricciones para cada día de la semana donde un objeto contiene la información sobre qué placas tienen restricción de circulación en ese día.
