import numpy as np 
from scipy.optimize import minimize_scalar 
def objective(t): 
    return np.abs(np.cos(t) + np.sin(t) - 2)  
    
result = minimize_scalar(objective) 
T = result.x 
print("El valor más pequeño de T es aproximadamente:", T)