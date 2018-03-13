#Homework 3
library(psych)

endo <- read.table("DAA.03.TXT", header=T)
endo$pid <- NULL
model3 = lm(endo$endurance ~ endo$age + endo$activeyears)
summary(model3)

model3.s = lm(scale(endo$endurance) ~ scale(endo$age) + scale(endo$activeyears))
summary(model3.s)

