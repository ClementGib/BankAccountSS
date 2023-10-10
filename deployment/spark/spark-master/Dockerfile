FROM ubuntu:latest
RUN apt-get update && apt-get install -y openjdk-11-jdk

ARG SPARK_VERSION
ARG HADOOP_VERSION
ADD https://downloads.apache.org/spark/spark-$SPARK_VERSION/spark-$SPARK_VERSION-bin-hadoop$HADOOP_VERSION.tgz /opt/
RUN tar -xvzf /opt/spark-$SPARK_VERSION-bin-hadoop$HADOOP_VERSION.tgz -C /opt/
RUN mv /opt/spark-$SPARK_VERSION-bin-hadoop$HADOOP_VERSION /opt/spark

ENV SPARK_HOME=${SPARK_HOME:-"/opt/spark"}
ENV HADOOP_HOME=${HADOOP_HOME:-"/opt/hadoop"}

# Exposition du port
EXPOSE 7077 8080

# Commande pour démarrer Spark Master
CMD ["/opt/spark/sbin/start-master.sh"]
