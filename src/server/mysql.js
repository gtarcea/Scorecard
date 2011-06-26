var sys = require('sys'),
    http = require('http');
//    mongo = require('mongodb');

var Client = require('mysql').Client,
    client = new Client(),
    database = 'fdl',
    table = 'Bills';

//var mongodb = new mongo.Db('fdl', new mongo.Server('localhost', 27017, {}, {}));

//mongodb.addListener("error", function(error) { sys.puts("Error connecting to mongodb"); });

client.host = 'localhost';
client.port = '3306';
client.database = 'fdl';
client.user = 'fdl';
client.password = 'fdl$%card!!';

client.connect();

client.query('select * from fdl.Bill',
             function select_cb(err, results, fields) {
                 if (err) { throw err; }
                 for (i in results)
                 {
                     console.log(results[i]);
                 /*
                     mongodb.open(function(err, mc) {
                                      var collection = new mongo.Collection(mc, 'bills');
                                      collection.insert(results[i], {safe:true}, function(merr, objects) {
                                                            if (merr) console.warn(merr.message);
                                                            if (merr && merr.message.indexOf('E11000 ') != -1)
                                                            {
                                                                console.warn("key already in database");
                                                            }
                                      });
                                      mc.close();
                     });*/
                 }
                 //console.log(results);
                 //console.log(fields);
                 client.end();
                 
             });