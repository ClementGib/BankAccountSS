
# Kubernetes startup with pods

### Requirement: 

- kubectl : kubernetes command-line tool (v1.28.2)
(https://kubernetes.io/docs/tasks/tools/)

## Information
Pods to build:
- spark-master : Spark master
- spark-worker1 : Spark worker 1
- spark-worker2 : Spark worker 2
- bank-account-spring : Bank account Java application

## Run

Build all Dockerfiles with the bash file:

```shell
# no argument, default version Spark 3.3.3 and Hadoop 3
./ba_script.sh 

# version arguments, Spark 3.5.0 and Hadoop 3
./ba_script.sh 3.5.0 3
```