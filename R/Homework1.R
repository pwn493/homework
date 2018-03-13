#Stats 1 Lecture 3 example script
#Read data, plot histograms, get descriptives
library(psych)

ratings <- read.table("DAA.02.TXT", header=T)
names(ratings)
#layout(matrix(c(1,2,3,4,5,6,7,8),4,2,byrow = TRUE))
#hist(ratings$pre.wm.s[ratings$cond=="aer"], main="pre s aer")
#hist(ratings$post.wm.s[ratings$cond=="aer"], main="post s aer")
#hist(ratings$pre.wm.v[ratings$cond=="aer"], main="pre v aer")
#hist(ratings$post.wm.v[ratings$cond=="aer"], main="post v aer")
##hist(ratings$pre.wm.s[ratings$cond=="des"], main="pre s des")
#hist(ratings$post.wm.s[ratings$cond=="des"], main="post s des")
#hist(ratings$pre.wm.v[ratings$cond=="des"], main="pre v des")
#hist(ratings$post.wm.v[ratings$cond=="des"], main="post v des")
designed <- subset(ratings, ratings$cond=="des")
aerobic <- subset(ratings, ratings$cond=="aer")
describe(designed)
describe(aerobic)
designed$cond <- NULL
designed$pid <- NULL
aerobic$cond <- NULL
aerobic$pid <- NULL
cor(designed)
cor(aerobic)