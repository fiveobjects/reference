use tvguide;
db.createCollection('program');
db.program.insertMany([
{
'title':'Casablanca',
'genre':'Movie',
},
{
'title':'Friends',
'genre':'Comedy',
}
]);