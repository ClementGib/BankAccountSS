# Configuration utilisé:

| Cluster manager | Execution mode |   |   |   |
|-----------------|----------------|---|---|---|
| Standalone      | Client mode    |   |   |   |

# Apache Spark

![cluster-manager.png](img/cluster-manager.png)


- [Français](#gestionnaires-de-cluster-apache-spark)
- [English](#apache-spark-cluster-managers)

## Gestionnaires de Cluster Apache Spark

Apache Spark utilise plusieurs gestionnaires de clusters pour:
- Allocation et gestion des ressources
- Coordination et planification des tâches
- Gestion des erreurs 
- Mise à l'échelle automatique
- Gestion de la communication
- Gestion des conteneurs 
- Sécurisation des ressources et accès utilisateurs
- Gestion des versions

### Type de gestionnaires de cluster (cluster managers) :

#### 1. Gestionnaire de Cluster Local

**Pour des tests et du développement sur une machine locale:** Gestionnaire de ressources local intégré, gestionnaire simplifié pour les opérations sur une seule machine.


#### 2. Standalone Cluster Manager (Gestionnaire de cluster autonome)

**Le gestionnaire de cluster autonome est inclus dans la distribution Apache Spark préféré pour les environnements de développement:**
- Facilité de configuration, utilisé pour des déploiements sur une petite échelle ou sur une seule machine ou pour les tests locaux sur un seul nœud.
- Fonctionne de manière autonome sur Spark contrairement à d'autres gestionnaires,
- Aucune dépendance externe (contrairement à YARN qui dépend d'Hadoop).

#### 3. Apache Hadoop YARN (Yet Another Resource Negotiator)

YARN est le gestionnaire de ressources utilisé dans l'écosystème Apache Hadoop.
Spark peut être déployé sur un cluster géré par YARN, bénéficiant ainsi des fonctionnalités avancées de gestion des ressources de YARN. 
- Cela permet le partage des ressources du cluster avec d'autres applications Hadoop.
- Fournit une gestion unifiée des ressources pour plusieurs frameworks de traitement des données, dont Apache Hadoop MapReduce et Apache Spark.
- Il prend aussi en charge la mise à l'échelle horizontale, ce qui signifie qu'il peut facilement s'adapter à une croissance du cluster en ajoutant de nouveaux nœuds de manière transparente.


_En plus des gestionnaires principaux, Spark prend également en charge d'autres gestionnaires de clusters :_

#### 4. Apache Mesos

Mesos est un gestionnaire de ressources distribuées compatible avec Spark.
- Il offre une grande flexibilité dans la gestion des ressources, permettant aux utilisateurs de partager les ressources entre différentes applications.
- Il est conçu pour être un gestionnaire de ressources générique et peut être utilisé avec différents frameworks d'application.
- Il offre aussi une API qui permet aux développeurs de créer leurs propres frameworks
#### 5. Kubernetes

À partir de Spark 2.3, Kubernetes est pris en charge en tant que gestionnaire de ressources. 
Kubernetes est un ecosystem  open source riche en possibilité  qui automatise le déploiement, la mise à l'échelle et la gestion des applications conteneurisées de plus il possède une grande communauté.

- Orchestration de conteneurs: applications Spark encapsulées dans des conteneurs Docker facilitant la gestion des dépendances et la portabilité des applications.

- Mise à l'échelle automatique, ajustant dynamiquement le nombre de pods Spark en fonction de la charge de travail.

- Simplification de la gestion des services Spark, facilitant l'exposition des services, la résolution des noms de service, et la mise en place de règles d'équilibrage de charge. 

- Il offre une tolérance aux pannes intégrée. En cas de défaillance d'un nœud, il peut redéployer automatiquement les pods Spark défaillants sur d'autres nœuds, garantissant la continuité des opérations.

- Il favorise la portabilité des applications Spark, permettant un déploiement cohérent sur divers environnements cloud et on-premise, il offre une flexibilité précieuse et facilite l'adoption multi-cloud


*Le choix du gestionnaire de cluster dépend souvent de l'environnement, des besoins spécifiques en matière de gestion des ressources et des préférences de l'utilisateur lors du déploiement de Spark.*

# Modes d'exécution dans Apache Spark

Apache Spark prend en charge différents modes d'exécution pour s'adapter à divers environnements et cas d'utilisation. Les modes d'exécution de Spark comprennent généralement les suivants :

| Mode d'Exécution | Fonctionnement                                        | Gestionnaires de Cluster                           | Outils de Développement               | Objectif                            |
|-------------------|------------------------------------------------------|----------------------------------------------------|---------------------------------------|------------------------------------|
| Local             | Driver et exécuteur sur le même JVM                  | Local                                              | Notebooks Spark shell ou IDEs       | Exécution locale pour le dev/test  |
| Client            | Driver sur la machine cliente, mais exécuteur sur le cluster | YARN (client)                                    | Notebooks Spark shell ou Spark-submit | Interaction avec les données et l'analyse de données |
| Cluster           | Driver et exécuteur dans des JVM séparées sur le cluster | YARN (cluster), Standalone, Mesos et Kubernetes   | Spark-submit, Notebooks Cloud       | Tâches de longue durée en production |

## 1. Mode Local

Dans ce mode, Spark s'exécute sur une seule machine, utilisant tous les cœurs disponibles. Souvent utilisé pour le développement et les tests sur une machine locale.

![local.png](img/local.png)

## 2. Mode Client

En mode client, le processus Driver s'exécute sur la machine cliente où l'application Spark est soumise.
Les tâches s'exécutent sur les nœuds du cluster. Couramment utilisé pour les déploiements sur des clusters YARN ou Mesos.
Si le client arrête les drivers, les exécuteurs sont également arrêtés.

![client.png](img/client.png)

## 3. Mode Cluster

En mode cluster, le processus Driver Spark s'exécute sur un nœud du cluster, séparé du nœud client.
Le Driver et les exécuteurs sont sur des processus JVM séparés, et chaque processus consomme des ressources sur le cluster.
Il s'agit du mode le plus courant pour les déploiements en production sur de grands clusters. Les tâches s'exécutent également sur les nœuds du cluster.

Ces modes peuvent être utilisés en combinaison avec différents gestionnaires de clusters, tels que le gestionnaire autonome, YARN, Mesos ou Kubernetes.
Le choix du mode d'exécution approprié dépend des exigences spécifiques de l'application, de la taille du cluster, des ressources disponibles et d'autres considérations opérationnelles.

![cluster.png](img/cluster.png)


# Apache Spark Cluster Managers

Apache Spark utilizes various cluster managers for:
- Resource allocation and management
- Task coordination and scheduling
- Error handling
- Automatic scaling
- Communication management
- Container management
- Resource security and user access
- Version management

## Types of Cluster Managers:

### 1. Local Cluster Manager

**For local testing and development:** Integrated local resource manager, a simplified manager for operations on a single machine.

### 2. Standalone Cluster Manager

**The standalone cluster manager is included in the Apache Spark distribution, preferred for development environments:**
- Easy configuration, suitable for small-scale or single-machine deployments and local testing on a single node.
- Operates independently within Spark, unlike other managers.
- No external dependencies (unlike YARN, which depends on Hadoop).

### 3. Apache Hadoop YARN (Yet Another Resource Negotiator)

YARN is the resource manager used in the Apache Hadoop ecosystem.
Spark can be deployed on a YARN-managed cluster, benefiting from advanced resource management features.
- Enables sharing cluster resources with other Hadoop applications.
- Provides unified resource management for multiple data processing frameworks, including Apache Hadoop MapReduce and Apache Spark.
- Supports horizontal scaling, easily adapting to cluster growth by seamlessly adding new nodes.

_In addition to the main managers, Spark also supports other cluster managers:_

### 4. Apache Mesos

Mesos is a distributed resource manager compatible with Spark.
- Offers flexibility in resource management, allowing users to share resources between different applications.
- Designed as a generic resource manager, can be used with different application frameworks.
- Provides an API for developers to create their own frameworks.

### 5. Kubernetes

Starting from Spark 2.3, Kubernetes is supported as a resource manager.
Kubernetes is a rich open-source ecosystem automating the deployment, scaling, and management of containerized applications, and it has a large community.

- Container Orchestration: Spark applications encapsulated in Docker containers facilitate dependency management and application portability.
- Automatic Scaling, dynamically adjusting the number of Spark pods based on workload.
- Simplifies Spark service management, making service exposure, service name resolution, and load balancing rule setup easy.
- Offers built-in fault tolerance. In case of node failure, it can automatically redeploy failing Spark pods on other nodes, ensuring operational continuity.
- Favors application portability, allowing consistent deployment across various cloud and on-premise environments, providing valuable flexibility and supporting multi-cloud adoption.

*The choice of the cluster manager often depends on the environment, specific resource management needs, and user preferences when deploying Spark.*

# Apache Spark Execution Modes

Apache Spark supports different execution modes to adapt to various environments and use cases. The Spark execution modes typically include the following:


| Execution Mode | How it works?                                        | Cluster Managers                                 | Development Tools                     | Purpose                            |
|----------------|------------------------------------------------------|--------------------------------------------------|---------------------------------------|------------------------------------|
| Local          | Driver & executor on same JVM                        | Local                                            | Spark shell notebooks IDEs            | Run locally for dev/tests          |
| Client         | Driver on client machine but executor on the cluster | YARN (client)                                    | Spark shell notebooks or Spark-submit | Interacting data and data analysis |
| Cluster        | Driver & executor in separate JVM on the cluster     | YARN (cluster), Standalone, Mesos and kubernetes | Spark-submit Cloud notebooks          | Long running jobs in production    |

### 1. Local Mode

In this mode, Spark runs on a single machine, utilizing all available cores. Often used for development and testing on a local machine.


![local.png](img/local.png)

### 2. Client Mode

In client mode, Driver runs on client machine where the Spark application is submitted. 
Tasks run on the cluster nodes. Commonly used for deployments on YARN or Mesos clusters.
If client kill drivers executors are killed as well.

![client.png](img/client.png)

### 3. Cluster Mode

In cluster mode, the Spark driver process runs on a cluster node, separate from the client node. 
Driver and executors are on separe JVM processes and each process consume resources on cluster.
The most common mode for production deployments on large clusters. Tasks also run on cluster nodes.

These modes can be used in combination with different cluster managers, such as the standalone manager, YARN, Mesos, or Kubernetes. 
Choosing the right execution mode depends on specific application requirements, cluster size, available resources, and other operational considerations.

![cluster.png](img/cluster.png)