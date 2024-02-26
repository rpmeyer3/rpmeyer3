import os
import tensorflow as tf
from tensorflow import keras

(train_images, train_labels), (test_images, test_labels) = \
tf.keras.datasets.mnist.load_data()

# normalize the pixel values
train_images = train_images / 255.0
test_images = test_images / 255.0

model = tf.keras.Sequential([
    tf.keras.layers.Flatten(input_shape=(28, 28)),
    tf.keras.layers.Dense(128, activation=tf.nn.relu),
    tf.keras.layers.Dense(10, activation=tf.nn.softmax)
])

model.compile(optimizer = tf.keras.optimizers.Adam(),
              loss = 'sparse_categorical_crossentropy',
              metrics=['accuracy'])

# use a callback function to stop the training early
callback = tf.keras.callbacks.EarlyStopping(monitor='val_loss', patience=3)
model.fit(train_images, train_labels, epochs = 5, validation_split=0.2, callbacks=[callback])

test_loss, test_acc = model.evaluate(test_images, test_labels)
print('test accuracy:', test_acc)

predictions = model.predict(test_images)

# plot the model structure
tf.keras.utils.plot_model(model, show_shapes=True, show_layer_names=True, to_file='model.png')

# use Graphviz to convert the PNG image to a PDF file
os.system('dot -Tpdf model.png -o model.pdf')
