#########
# Macnamara, Moore, & Conway (2011), Experiment 1, Serial SR
#########

library(psych)
library(car)
source(file="eta_squared.R")

e1sr <- read.table("DAA.05.txt", header = T)

# Omnibus analysis is a 3x2 mixed factorial with condition and timeuli as the independent variables and serial SR as the dependent variable.  The three levels of condition are word span, reading span, and story span.  The two levels of timeuli are phonologically similar and phonologically dissimilar.

time = factor(e1sr$time,levels=c("pre","post"))  #reverse levels (for graphs like the article)

aov.e1sr = aov(e1sr$SR ~ (e1sr$condition*e1sr$time) + Error(factor(e1sr$subject)/e1sr$time))
summary(aov.e1sr)
eta.2(aov.e1sr, ret.labels=TRUE)


# Levene's test
leveneTest(e1sr$SR, e1sr$condition, center="mean")


# Simple effects analysis for simple span (i.e., word span)
aov.e1srwm = aov(e1sr$SR[e1sr$condition=="WM"] ~ e1sr$time[e1sr$condition=="WM"] +Error(factor(e1sr$subject[e1sr$condition=="WM"])/e1sr$time[e1sr$condition=="WM"]))
summary(aov.e1srwm) 
eta.2(aov.e1srwm, ret.labels=TRUE)

# Simple effects analysis for simple span (i.e., word span)
aov.e1srpe = aov(e1sr$SR[e1sr$condition=="PE"] ~ e1sr$time[e1sr$condition=="PE"] +Error(factor(e1sr$subject[e1sr$condition=="PE"])/e1sr$time[e1sr$condition=="PE"]))
summary(aov.e1srpe) 
eta.2(aov.e1srpe, ret.labels=TRUE)

# Simple effects analysis for simple span (i.e., word span)
aov.e1srds = aov(e1sr$SR[e1sr$condition=="DS"] ~ e1sr$time[e1sr$condition=="DS"] +Error(factor(e1sr$subject[e1sr$condition=="DS"])/e1sr$time[e1sr$condition=="DS"]))
summary(aov.e1srds) 
eta.2(aov.e1srds, ret.labels=TRUE)

# Simple effects analysis for complex span (this is a 2x2 mixed factorial)
aov.e1srnwm = aov(e1sr$SR[e1sr$condition!="WM"] ~ e1sr$condition[e1sr$condition!="WM"]*e1sr$time[e1sr$condition!="WM"] + 
  Error(factor(e1sr$subject[e1sr$condition!="WM"]) / e1sr$time[e1sr$condition!="WM"]))
summary(aov.e1srnwm) 
eta.2(aov.e1srnwm, ret.labels=TRUE)


#######

#Graph

# Bar plot

wmspan = describe.by(e1sr$SR[e1sr$condition=="WM"], group = time[e1sr$condition =="WM"], mat = T)
pespan = describe.by(e1sr$SR[e1sr$condition=="PE"], group = time[e1sr$condition =="PE"], mat = T)
dsspan = describe.by(e1sr$SR[e1sr$condition=="DS"], group = time[e1sr$condition =="DS"], mat = T)
graphme = cbind(Words = wmspan$mean, Sentences = pespan$mean, Stories = dsspan$mean)
rownames(graphme) = c("Phonologically Similar", "Phonologically Dissimilar")
se = cbind(wmspan$se, pespan$se, dsspan$se)

bp = barplot(graphme, beside = TRUE,
        ylim = c(0,1), space = c(0, .5), legend.text = TRUE, 
        args.legend = c(x = "topright"))
abline(h=0)
for (ii in 1:3) {
  arrows(bp[1, ii], graphme[1,ii] - se[1, ii],
		 y1 = graphme[1,ii] + se[1, ii], angle = 90, code = 3)
  arrows(bp[2, ii], graphme[2,ii] - se[2, ii],
  	 y1 = graphme[2,ii] + se[2, ii], angle = 90, code = 3)
	}
	
#######