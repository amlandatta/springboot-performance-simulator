# How to configure custom metrics in PCF Metrics 1.6?

Refer: [Steps to register metrics endpoint](https://docs.pivotal.io/platform/application-service/2-8/metric-registrar/using.html#json)

* Install plugin

```
cf install-plugin -r CF-Community "metric-registrar"
```

* Register a Public Metrics Endpoint
> Note: that the metrics endpoint gets bound to app as service instance

```
cf register-metrics-endpoint adperfsimulator /actuator/prometheus
```

* Register a Structured Log Format

```
cf register-log-format adperfsimulator json
```

* Check registered endpoints

```
cf registered-metrics-endpoints
```

PCF Metrics 1.6.x should have been installed.
Metrics will appear in PCF metrics after sometime and then you can add to the dashboard

* Launch metrics.sys.domain and search for your app
* Click add metrics, you should see custom metrics like jvm_memory_used_bytes etc. Select to add metrics


Refer sample dashboard

> PCF Metrics 1.x is not declarative hence you need to add metrics manually to each app dashboards.
PCF Metrics 2.x is declarative.

Next > [Customize PCF Metrics 2.0.x](customize-pcf-metrics-2-0.md)

[Back to Table of Content](../README.md)
