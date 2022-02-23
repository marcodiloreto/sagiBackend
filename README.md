# sagiBackend

#### Intentando conseguir la data de la base de datos usando JPA, con LazyFetching para las colecciones entre entidades
Resulta que me pide siempre una Session de hibernate, lo que es bastante extraño por que el proxy es de JPA, que se supone que debería funcionar de forma independiente.
De todos modos, para usar la Session de hibernate, necesito usar las transacciones de hibernate también, así que el @Transactional me dejaría de servir.
He intentado hacerlo pero no logro configurar el SessionFactory como Bean para tener manejo de Sessions.

De todos modos estoy buscando alguna forma de prescindir del uso de Sessions de hibernate, para poder utilizar @Transactional y facilitar el flujo de datos.

En este momento el Package application.repository no está siendo usado para nada, estoy usando application.JPArepository
