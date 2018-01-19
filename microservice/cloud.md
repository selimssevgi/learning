# What exactly is the cloud?

- There basic models exist in cloud-based computing:

1. Infrastructure as a Service (IaaS) = AWS, GCP, Azure
2. Platform as a Service (PaaS) = Heroku
3. Software as a Service (SaaS)
4. Functions as a Service (FaaS) = AWS Lambda, Serverless
5. Container as a Service (CaaS) = AWS ECS(Elastic Container Service)


* Let's map the everyday task of making a meal to the different models of cloud computing

- When you want to eat a meal, you have four choices:

1. You can make the meal at home
2. You can go to the grocery store and buy a meal pre-made, heat-up and serve
3. You can get a meal delivered to your house
4. You can get in the car and eat at restaurant

- The different cloud computing models come down to who's responsible for what

```shell

+---------------+ +---------------+ +---------------+ +---------------+
| Furniture    +| | Furniture    +| | Furniture    +| | Furniture    -|
| Plates       +| | Plates       +| | Plates       +| | Plates       -|
| Oven         +| | Oven         +| | Oven         -| | Oven         -|
| Ingredients  +| | Ingredients  -| | Ingredients  -| | Ingredients  -|
| Chef         +| | Chef         -| | Chef         -| | Chef         -|
+---------------+ +---------------+ +---------------+ +---------------+
| Homemade      | | Store bought  | |   Delivered   | |   Restaurant  |
+---------------+ +---------------+ +---------------+ +---------------+
+---------------+ +---------------+ +---------------+ +---------------+
| On premise    | |     IaaS      | |     PaaS      | |     SaaS      |
+---------------+ +---------------+ +---------------+ +---------------+
 
// +: you manage, -: provides manages
```
