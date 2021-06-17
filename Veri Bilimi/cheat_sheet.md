## Colab TPU Kullanma
`get_model()` : modelin tanımlandığı fonksiyon
```python
import tensorflow as tf

sgd = tf.keras.optimizers.SGD(learning_rate=0.001, momentum=0.9)

tpu = tf.distribute.cluster_resolver.TPUClusterResolver()
tf.config.experimental_connect_to_cluster(tpu)
tf.tpu.experimental.initialize_tpu_system(tpu)
strategy = tf.distribute.experimental.TPUStrategy(tpu)

with strategy.scope():
  tpu_model = get_model()

tpu_model.compile(loss="categorical_crossentropy", optimizer=sgd)
```

## one hot encoding ve tersi
One Hot Encoding
```python
y = pd.get_dummies(y)
```
veya
```python
y = tf.keras.utils.to_categorical(y)
```
tersi
```python
y_pred = np.argmax(y_pred, axis=-1)
```
