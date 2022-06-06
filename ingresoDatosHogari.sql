

INSERT INTO `Contactanos` 
(`idListaLlamada` ,`FechaLlamada`,`OrigenLlamada`,`origenEmail`) VALUES 
('01','2022-02-20','Guadalajara','mario@gmail.com'),
('02','2022-02-22','Guadalajara','carlos@gmail.com'),
('03','2022-02-24','Puebla','maria@gmail.com'),
('04','2022-03-02','Queretaro','marcos@gmail.com'),
('05','2022-03-08','Puenla','fabiola@gmail.com');

INSERT INTO `Usuario` 
(`idUsuario`,`Nombre`,`Apellido`,`Numero_Contacto`,`CP`,`Password`,`email`,
  `ListaLlamada_idListaLlamada`,`Es_arrendador?`) VALUES
  (1, 'Mario','Alvarado','331995208','45019','Contrasena123','mario@gmail.com',01,'NO'),
  (2, 'Juan','Perez','3318952070','45402','Chocolate321','mario@gmail.com',01,'SI'),
  (3, 'Linda','Medina','331558837','45018','123Contrasena','mario@gmail.com',01,'SI'),
  (4, 'Elena','Villa','3315228899','55019','Yosoygroot123','mario@gmail.com',01,'NO'),
  (5, 'Luis','Cruz','3318992012','45210','Sorpresa4123','mario@gmail.com',01,'NO');
  
INSERT INTO `Renta` 
(`idPedido`,`idUsuario`,`idInmueble`,`Periodo`,`FolioRegistro`) VALUES
 (20, 3,08,90,'45019'),
 (21, 10,09,120,'45050'),
 (22, 4,10,120,'40019'),
 (23, 8,30,365,'35019');
 
 INSERT INTO `Inmueble`
 (`idInmmueble`,`Ciudad`,`Tipo_Inmueble`,`Costo`,`Num_Personas`, `Mascotas`,`Descripcion`,
  `Dimensiones_m2`,`Renta_idPedido`,`Renta_idUsuario`, `Renta_idInmueble`) VALUES
  (06,'Guadalajara','Casa',5000,3,'no','A',80,20,15);
  
  INSERT INTO `Usuario_has_Renta` 
  (`Usuario_idUsuario`, `Usuario_CP`,`Usuario_ListaLlamada_idListaLlamada`,`Renta_idPedido`, 
	`Renta_idUsuario`,`Renta_idInmueble`) VALUES
    (10,'4444',03,90,'6000');
  
  
  
 

  
  