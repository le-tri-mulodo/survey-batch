##Benchmark result

###Import use Hibernate

| Chunk size | Record | Duration 1st (ms) | Duaration 2nd | Duration 3rd |
| ------------- | ------------- |	------------- |	-------------	| ------------- |
| 500 | 1000000 |	337,612 | 365,326	| 395,024 |
| 1000 | 1000000 |	306,099 |	340,374 | 317,573 |
| 1500 | 1000000 |	301,560 |	354,468 | 330,065 |

----------------------------------------------------
###Import use JDBC

| Chunk size | Record | Duration 1st (ms) | Duaration 2nd | Duration 3rd |
| ------------- | ------------- |	------------- |	-------------	| ------------- |
| 50000 | 1000000 |	33,905 |	35,228	| 37,628 |
| 100000 | 1000000 |	32,664 |	34,613	| 36,625 |

----------------------------------------------------
###Copy use Hibernate

| Chunk size | Pagesize | Record | Duration 1st (ms) | Duaration 2nd | Duration 3rd |
| ------------- | ------------- |	------------- |	-------------	| ------------- | ------------- |
| 1500 | 3000 |	1000000 |	353,714	| 377,476 | 371,284 |
| 50000 | 100000 |	1000000 |	363,559	| 347,464 | 349,948 |

----------------------------------------------------
###Copy use JDBC

| Chunk size | Pagesize | Record | Duration 1st (ms) | Duaration 2nd | Duration 3rd |
| ------------- | ------------- |	------------- |	-------------	| ------------- | ------------- |
| 1500 | 3000 |	1000000 |	45,658	| 48,673 | 50,478 |
| 50000 | 100000 |	1000000 |	33,150 | 34,711 | 36,080 |
| 100000 | 100000 |	1000000 |	36,623 | 35,439 | 39,239 |
