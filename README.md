# springboot-performance-simulator
A test SpringBoot app to simulate performance by inducing latency, spiking memory usage, creating errors, etc and deploy on PCF (PAS)

* Build app

```
cd springboot-performance-simulator
mvn clean package -DskipTests
```

* Deploy app to PAS

```
cd springboot-performance-simulator
cf push --vars-file=vars-myenv.yml
```
> change domain name in vars-myenv.yml

* Rest end-points

__Simulate latency__


* (0 ms) <https://adperformancesimulator.apps.myenv.com>/simulate/delay
* (1000 ms) <https://adperformancesimulator.apps.myenv.com>/simulate/delay/1000
* (random delay) <https://adperformancesimulator.apps.myenv.com>/simulate/randomdelay

__Simulate error__, to log errors and can be useful to test scalability of log flow

* <https://adperformancesimulator.apps.myenv.com>/simulate/error

__Simulate memory__, to push app's memory usage in MB

* (1 MB) <https://adperformancesimulator.apps.myenv.com>/simulate/memory
* (5 MB) <https://adperformancesimulator.apps.myenv.com>/simulate/memory/5

__Simulate app health check issue__
  
 * Include in `manifest.yml`, `health-check-invocation-timeout` in sec
	  
 ```
 health-check-invocation-timeout: 10
 ```
	  
 * Push app using cf7 (CF V3 API)
	
 ```
 cd springboot-performance-simulator
 cf push --vars-file=vars-myenv.yml
 ```

 * Say you configured, 10 sec timeout for your app health endpoint latency
 
	 To simulate latency, first hit with say 15 sec latency
	 
	 * <https://adperformancesimulator.apps.myenv.com>/health/15
	
	 This will ensure that <https://adperformancesimulator.apps.myenv.com>/health also responds after 15 secs. At this point, expect application to crash
	
	 If you changed default health latency and want to reset to normal, hit below URL
	 
	 * <https://adperformancesimulator.apps.myenv.com>/health/0
