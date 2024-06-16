#!/bin/bash

# Version with argument or defaulting
SPARK_VERSION=${1:-3.3.3}
HADOOP_VERSION=${2:-3}

echo $SPARK_VERSION
echo $HADOOP_VERSION
# Define the list of directories containing Dockerfiles
directories=("spark/spark-master" "spark/spark-worker-1" "spark/spark-worker-2")
#TODO
#directories=("spark/spark-master" "spark/spark-worker-1" "spark/spark-worker-2" "spark/bank-account-spring")

# Loop through each directory and build the Docker image
for dir in "${directories[@]}"; do
    echo "Building image for $dir with Spark version $SPARK_VERSION and Hadoop version $HADOOP_VERSION."
    docker build --build-arg SPARK_VERSION="$SPARK_VERSION" --build-arg HADOOP_VERSION="$HADOOP_VERSION" -t "$dir-image" ./"$dir"
done

echo "All Docker images built successfully."


echo "Docker images deployment in Kubernetes cluster"
kubectl apply -f pods/
kubectl get pods