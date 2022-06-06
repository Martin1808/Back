 INSERT INTO `Hogari`.`Usuario` (
  `Nombre` ,`Apellido`,`Numero_contacto` ,`Password` ,`Email` ,`Es_arrendador?` ,`Imagen_perfil`)
   VALUES
  ( 'Mario','Alvarado','331995208','Contrasena123','mario@gmail.com','NO','image1.jpg'),
  ( 'Juan','Perez','3318952070','Chocolate321','mario@gmail.com','SI','image2.jpg'),
  ('Linda','Medina','331558837','123Contrasena','mario@gmail.com','SI','image3.jpg'),
  ( 'Elena','Villa','3315228899','Yosoygroot123','mario@gmail.com','NO','image4.jpg'),
  ('Luis','Cruz','3318992012','Sorpresa4123','mario@gmail.com','NO','image5.jpg');
  
  
  INSERT INTO `Hogari`.`Imagenes` (
  `nombre_archivo` ,`Reservacion_idReservacion` ,`Reservacion_Usuario_idUsuario`,`Reservacion_Inmueble_idInmueble`,
  `Reservacion_Inmueble_Usuario_idUsuario`)
  
   VALUES
  ('img1.jpg','12345',1,'1234','123'),
  ('img2.jpg','647454',2,'564785','456'),
  ('img3.jpg','51551',3,'15615','789'),
  ( 4,'img4.jpg','265944',4,'1567','101'),
  ( 5,'img5.jpg','4654981',5,'18949','12145');
  
  
  
  INSERT INTO `Hogari`.`Inmueble` (`Ciudad` ,`Direccion` ,`Tipo_Inmueble` ,`NumeroPersonas`,
  `Mascotas` ,`Descripcion` ,`Dimensiones` ,`Precio` ,`Publicacion` ,`Creacion_publicacion` ,
  `Updated_publicacion` ,`Usuario_idUsuario` ,`Imagenes_idImagenes` ,`Imagenes_Reservacion_idReservacion` ,
  `Imagenes_Reservacion_Usuario_idUsuario` ,
  `Imagenes_Reservacion_Inmueble_idInmueble` ,`Imagenes_Reservacion_Inmueble_Usuario_idUsuario`)
  
   VALUES
('Guadalajara','Calle1','casa',3,
'no','A',80,2000,'2022-04-23 12:52:15','2022-04-23 12:52:15','2022-04-23 12:52:15',
1,1,1,1,1,1),

('Mexico','Calle2','departamento',5,
'si','Descripcion2',120,4500,'2022-04-23 12:52:15','2022-04-23 12:52:15','2022-04-23 12:52:15',
2,2,2,2,2,2),

('Puebla','Calle3','casa',10,
'no','Dscripcion3',100,2030,'2022-04-23 12:52:15','2022-04-23 12:52:15','2022-04-23 12:52:15',
1,1,1,1,1,1),

('Guadalajara','Calle4','departamento',2,
'si','A',200,8000,'2022-04-23 12:52:15','2022-04-23 12:52:15','2022-04-23 12:52:15',
1,1,1,1,1,1),

('Mexico','Calle7','casa',4,
'si','Descripcion7',150,5000,'2022-04-23 12:52:15','2022-04-23 12:52:15','2022-04-23 12:52:15',
1,1,1,1,1,1);


  
  
  
  