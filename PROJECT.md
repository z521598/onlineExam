## module设计

##### user 
> 用户表  
> id username passwd name sex birthday idcard  

##### paper
> 试卷  
> id title totalMark author time 

##### question
> 问题   
> id qusetion answer type mark paper_id   

##### exam
> 测验  
> id paper_id user_id time mark

##### answer
> 用户答案
> id content question_id user_id exam_id 

##### notice 
> 考试通知
> id content paper_id
##### 
