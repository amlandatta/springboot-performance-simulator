## Contents

* [SpringBoot performance simulator app](/springboot-app-simulator-doc.md)
> A test SpringBoot app to simulate performance by inducing latency, spiking memory usage, creating errors, etc and deploy on PCF (PAS).
This application is integrated with Spring Cloud Services - Service Registry

* Build app

```
cd springboot-performance-simulator
mvn clean package -DskipTests
```

* Edit the following

[vars-myenv.yml](vars-myenv.yml)

```
# replace with your domain
domain: apps.myenv.com

# replace with your backend application name
backend-app-name: backend-app
```


[manifest.yml](manifest.yml)

```
# replace with your service-name for service registry
  services:
   - ad-registry-service
```


* Deploy app to PAS

```
cd springboot-performance-simulator
cf push --vars-file=vars-myenv.yml
```


* Deploy app to PAS

First, replace appname in [vars-myenv.yml](vars-myenv.yml)

```
app_name: backend-app
```

```
cf push --vars-file=vars-myenv.yml
```


* [Custom metrics in SpringBoot app](pas-metrics/README.md)
> How to monitor custom SpringBoot app metrics using PCF Metrics 1.6?

* [Customize PCF Metrics 1.6.x](pas-metrics/customize-pcf-metrics-1-6.md)
> How to configure custom metrics in PCF Metrics 1.6?

* [Customize PCF Metrics 2.0.x](pas-metrics/customize-pcf-metrics-2-0.md)
> How to configure custom metrics in PCF App Metrics 2.0?

* [Multi app dashboard in PCF Metrics 2.0.x](pas-metrics/customize-pcf-metrics-2-0.md#how-to-configure-multiple-app-metrics-in-single-dashboard)
> How to configure Multiple App metrics in single dashboard?
