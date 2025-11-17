"(In this case, M=2N, so α = 1/2).  I strongly recommend talking about your results with others in the group, e.g. in a breakout room."

    Load factor of alpha is 0.5: M = 2 N, values in table = N

    Average probes for a miss with N=1000 is: 2.3872
    Average probes for a miss with N=10000 is: 2.5048
    Average probes for a miss with N=100000 is: 2.5161
    Average probes for a miss with N=1000000 is: 2.4927

The formula is ~1/2(1+(1/(1-a)^2): which is 2.5

"Now, repeat this experiment, but alter your code in exactly one way: change the size of the hash table array so that it is M = 1.5N, instead of 2N  (α = 2/3)."

    Load factor of alpha is 0.66: M = 1.5 N, values in table = N

    Average probes for a miss with N=1000 is: 5.77
    Average probes for a miss with N=10000 is: 5.025
    Average probes for a miss with N=100000 is: 5.1303
    Average probes for a miss with N=1000000 is: 5.0648

    The formula is ~1/2(1+(1/(1-0.66)^2): which is 5

"Repeat the experiment again, now with , but alter your code in exactly one way: change the size of the hash table array so that it is M = 1.25N instead of 2N  (α = 4/5)."

    Load factor of alpha is 0.8: M = 1.25 N, values in table = N

    Average probes for a miss with N=1000 is: 13.9551
    Average probes for a miss with N=10000 is: 12.0648
    Average probes for a miss with N=100000 is: 12.8885
    Average probes for a miss with N=1000000 is: 12.7431

    The formula is ~1/2(1+(1/(1-0.8)^2): which is 12.5