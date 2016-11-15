# 整理过去项目:
  1 广告模型在线训练系统
  2 广告模型流式训练数据系统
  3 分布式数据库引擎优化
  4 图片caption模型(neuraltalk, show and tell)
  5 手机信令API处理平台







1. Online Advertising Training System. 2015.1 - now
I developed a distributed model training system. The model is used to predict Click Through Rate(CTR) of Adversiment. The system is based on Storm/Kafka-like infrastructure. The training data is generated via click/impression log and join with user/ads/context features(stored in distributed KV), then feed into one-pass(online) algorithm(FTRL) and periodically dump the model for serving. In order to equally placed the memory consumed component I developed custom scheduler of storm.
2. Training Data Generation System. 2013.1 - 2014.12
The click/impression log first fill into distributed queuing system(Kafka-like), then divided into different Ad position and extract keys to join with user/ads/context features, and finally dump training data into HDFS for offline model training purpose. I use 32*8 cpu to handle 15 Billions impression for each cluster set(I have 2 set, one for production, another for experiment)
3. Online Training Monitor 2015.1 - 2015.5
I designed and developed plenty of metric for monitoring task, for the model specific: Delay AUC, Realtime AUC, Loss, Misclassification-rate, model-size; for the system specific: memory-used, batch-process-time. This project initially base on Graphite. Then I expanded the monitoring system to include metric from Training Data Generation System and Online Advertising Training System and migrated it into another more featured monitoring system(dev by another team).
4. Distributed Database Engine Optimizer 2012.6 - 2013.1
I developed Bool Expression Analyzer which is the fundamental component of Optimizer in SQL compiler. I implemented the Quine McCluskey algorithm to generate conjunctive normal form(CNF) and use Petrick Method to get Minimal-CNF. Based on the bool expression analyzer, I developed Predicate PushDown Optimzer for logical plan. And I also developed Reduce Shuffling Optimzer for physical plan.



Develop distributed online training system for the Tencent performance-based advertising platform , especially aim to make lift to Click Through Rate(CTR) and Effective Cost Per Mille(ECPM). I responsible for the online training system which include stream Training Data module and Online Training module. Training Data module join the user click/impression log with the feature(User/Ads/Context) in real-time manner; and Online Training module use many kinds of one-pass algorithm(FTRL/Adpredictor, etc.) to produce modal.


Pinterest is one of the fastest growing online advertising platforms, and our continued success depends on the reliability, performance, and scalability of the Ads Serving system. We are looking engineers with experience and a passion in distributed systems to help us build the next-generation Ads Serving system that will deliver world class performance, and scale to 100x our current size (query volume, number of advertisers, number of ad creatives, number of product offerings). You willll join a small, early-stage team, working on multiple critical functional areas and lay the foundation for Pinterest’s business success.

What You will Do
Own and grow the core functional areas of the Ads Serving system—ads serving system, ads indexing/retrieval system, ads ranking/training system, and ads data processing/warehousing system
Apply Distributed Systems principles to build next-generation ads serving, indexing, and model training systems
Use Big Data technologies (Spark, Hadoop, Hive, etc.) to build next-generation ads data processing/warehousing system
Improve core Ads Serving services components to achieve greater reliability, availability, modularity, and latency
Develop processes to systematically evaluate the Ads Serving system for regressions in system performance and key business metrics


What We are Looking For
2+ years of experience with distributed systems, data infrastructure, and coding
Proficiency in multiple systems languages (Java, C++, Go)
Experience in Big Data technologies (Hadoop, Spark, Hive, Storm, Samza)
Experience in building and owning critical user-facing backend serving systems
Experience in building large-scale Machine Learning training systems
