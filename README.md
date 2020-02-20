## Contents

* [SpringBoot performance simulator app](springboot-app-simulator-doc.md)
> A test SpringBoot app to simulate performance by inducing latency, spiking memory usage, creating errors, etc and deploy on PCF (PAS)

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

* [Custom metrics in SpringBoot app](pas-metrics/README.md)
> How to monitor custom SpringBoot app metrics using PCF Metrics 1.6?

* [Customize PCF Metrics 1.6.x](pas-metrics/customize-pcf-metrics-1-6.md)
> How to configure custom metrics in PCF Metrics 1.6?

* [Customize PCF Metrics 2.0.x](pas-metrics/customize-pcf-metrics-2-0.md)
> How to configure custom metrics in PCF App Metrics 2.0?

* [Multi app dashboard in PCF Metrics 2.0.x](pas-metrics/customize-pcf-metrics-2-0.md#how-to-configure-multiple-app-metrics-in-single-dashboard)
> How to configure Multiple App metrics in single dashboard?
