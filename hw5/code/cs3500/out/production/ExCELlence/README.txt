# ExCELlence
A animation program written in Java.
Our program is structured as follows. At the highest layer there is the model, which is the point
of access for future implementation.
Each AnimationModelImpl is initialized with hashmap of Strings to Shapes. This allows shapes to be
accessed in O(1) time, instead of parsing through a list.
The AnimationModelImple is capable of adding a shape, adding an animation to an individual shape,
and getting a description of the entire animation. Each shape is referred to by the String held in
its field name. As a result, a shape's name needs to be unique, or else an error will be thrown.
Moving on to shapes, each shape has the basic information needed to render it, dimensions, position,
  name, color. However each shape also carries with it an ArrayList of keyPoints, which are
  important points in the animation, namely where animations start and end.
In conjunction with this ArrayList, each shape also has a hashmap of integers to an ArrayList of
Animations. As such, the shape can quickly retrieve all the animations occuring at any keypoint.
When adding an animation, it is important to remember to make sure the start time of the animation
either lines up with another keyPoint, or the end of the last animation to be occur.
Inside there is a function performActions(int key), which takes all the Animations at keyPoint key
and applies them to the shape. This function is then used in the function getDescription(int key),
which prints the before and after of any keyPoint for the shape.
The function getFullDescription() calls getDescription() for each keyPoint and compiles them in an
output string.
The last portion of our implementation, the animations themselves, are fairly simple objects. They
only hold their start and end time, as well as the new value for the shape they will be added to.
Each animation has a function apply(Shape s), where they change the proper attributes of the shape.
 Each class of shape implements this function differently. This method of passing the shape as a
 parameter, means that the same animation can apply to multiple shapes.

The views are divided into three classes, SVGView, TextView, and AnimationView. Each represents the
animation in a different way. SVGView outputs the animation in a svg format, with the option of
outputting to the console or an appendable. This means it can be outputted to a .svg file and
ultimately played in a browser. On the other hand, the AnimationView class displays the animation in
 a JFrame on the users computer. This is the most user-friendly option as it only requires hitting
 run. Lastly, the TextView outputs the animation in a text-based format once again either to the
 console or a .txt file. This format lists a shape, and then lists all its animations. The
 Excellence class serves as the main point of contact between the user and the program. This class,
 has a main method which can be run with command line arguments to specify what the user wants. The
 command -in specifies where the animation should come from, and will be interpreted by the
 AnimationBuilder class. The command -view specifies which of the three views to be used ("visual",
 "text", or "SVG"). The command -out specifies the output file; if none is provided, it will default
  to System.out. Lastly the command -speed is used to set the simulation speed of the animation in
  ms.
