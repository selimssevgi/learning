# Cloud Abstractions

- Functions - FaaS
- Applications - PaaS
- Containers - CaaS
- Virtual Machines - IaaS

IaaS             | CaaS             | PaaS             | FaaS
---------------------------------------------------------------------
+Functions       | +Functions       | +Functions       | xFunctions       |
+Application     | +Application     | xApplication     | +Application     |
+Runtime         | +Runtime         | /Runtime         | /Runtime         |
+Containers      | xContainers      | /Containers      | /Containers      |
xOS              | /OS              | /OS              | /OS              |
/Virtualization  | /Virtualization  | /Virtualization  | /Virtualization  |
/Hardware        | /Hardware        | /Hardware        | /Hardware        |

- + customer managed
- x customer managed unit of scale
- / Abstracted by Vendor

### PaaS vs FaaS

Paas                               | Faas
-------------------------------------------------------------------
runs apps                          | runs functions
push app to deploy server          | register function and bind it to a trigger
server runs and waits for requests | function does not run until triggered
server listens to network          | platform deploys and invokes functions
server handles lots of requests    | functions handle 'events' and then go away
scale out manually or by policy    | 'auto-scale' based on concurrent event load
pay per instance                   | pay per use-time and memory

