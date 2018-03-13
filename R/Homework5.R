#Homework5
#t tests in R
library(psych)
wm <- read.table("DAA.04.TXT", header = T)

describe.by(wm, wm$training)

wm.sp = subset(wm, wm$training == "SP")
wm.wm = subset(wm, wm$training == "WM")

wm.sp.out = describe(wm.sp)
wm.sp.out
wm.wm.out = describe(wm.wm)
wm.wm.out

#dependent test
t.test(wm.sp$pre, wm.sp$post, paired = T)
t.test(wm.wm$pre, wm.wm$post, paired = T)

#cohen's d for depenent
d.c = (wm.sp.out[4,3])/(wm.sp.out[4,4]) #mean gain score / std
d.c
d.t = (wm.wm.out[4,3])/(wm.wm.out[4,4])
d.t

#independent t test
t.test(wm$gain ~ wm$training, var.equal = T)

#Cohen's d for independent t tests
df.t = 19
df.c = 19
df.total = 38
pooled.sd = (df.t/df.total * wm.wm.out[4,4]) + (df.c/df.total * wm.sp.out[4,4])
d.ct = (wm.wm.out[4,3] - wm.sp.out[4,3]) / pooled.sd
d.ct

#anova
aov.model = aov(wm.wm$gain ~ wm.wm$training)
summary(aov.model)
aov.table = summary(aov.model)

#effect size for ANOVA
ss = aov.table[[1]]$"Sum Sq"
eta.sq = ss[1] / (ss[1]+ ss[2])
eta.sq

#post-hoc tests
TukeyHSD(aov.model)

# Levene's test
library(car)
leveneTest(wm.wm$gain, wm.wm$training, center="mean")
