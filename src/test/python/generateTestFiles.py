import numpy as np
import sys
import json

generator = np.random.Generator(np.random.PCG64())

outputJson = []


def random_mat():
    return generator.integers(-10000, 10000, (3, 3))


for _ in range(100):
    mat1 = random_mat()
    mat2 = random_mat()
    multipliedMat = mat1.dot(mat2)
    outputJson.append({
        "first": mat1.tolist(),
        "second": mat2.tolist(),
        "result": multipliedMat.tolist()
    })

with open("../resources/matrixMatrixOperationsTest.json", "w") as file:
    json.dump(outputJson, file, indent="  ")

outputJson = []
for _ in range(100):
    mat = random_mat()
    vec = generator.integers(-1000, 1000, (3,))
    result = mat.dot(vec)
    outputJson.append({
        "first": mat.tolist(),
        "second": vec.tolist(),
        "result": result.tolist()
    })

with open("../resources/matrixVectorOperationsTest.json", "w") as file:
    json.dump(outputJson, file, indent="  ")
