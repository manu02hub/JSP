

var data = {
    "ES-B": 200, // Barcelona
    "ES-M": 300, // Madrid
    "ES-BI": 400, // Bilbao
    "ES-O": 500, // Asturias
    "ES-C": 600, // Coruña
    "ES-MU": 700, // Murcia
    "ES-S": 800, // Santander
    "ES-SE": 900, // Sevilla
    "ES-Z": 1000, // Zaragoza
};

$('#my-map').vectorMap({
    map: 'es_mill', // el mapa del mundo
    series: {
        regions: [{
            values: data, // los valores
            scale: ['#0d3ce0', '#20B2AA'], // el rango de colores
            normalizeFunction: 'polynomial' // la formula de normalizacion de datos
        }]
    },
    
});