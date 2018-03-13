#Lecture 12
library(psych)
library(multilevel)

happy <- read.table("STATS1.EX.05.TXT", header=T)
happy$pid <- NULL

#mediation
describe(happy)
hist(happy$happy)
hist(happy$extra)
hist(happy$diverse)

plot(happy$happy~happy$extra)
abline(lm(happy$happy ~ happy$happy))


model1 = lm(happy$happy ~ happy$extra)
summary(model1)

model2 = lm(happy$happy ~ happy$diverse)
summary(model2)

model3 = lm(happy$happy ~ happy$extra + happy$diverse)
summary(model3)

indirect = sobel(happy$extra, happy$diverse, happy$happy)
indirect

#moderation
mod <- read.table("STATS1.EX.06.TXT", header=T)
mod$pid <- NULL

no.mod.model = lm(mod$happy ~ mod$extra + mod$ses)
summary(no.mod.model)

mod.model = lm(mod$happy ~ mod$extra + mod$ses + mod$mod)
summary(mod.model)

anova(no.mod.model, mod.model)
