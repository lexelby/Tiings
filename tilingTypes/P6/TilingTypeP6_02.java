package tilingTypes.P6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP6_02
   extends TilingType
{
   public TilingTypeP6_02(){
      super( "P6-2&9", 6, SymmetryType.pg );

      paramMin = new int[]{-90,  0,-180,  0};
      paramMax = new int[]{ 90,100, 180,500};
      paramDef = new int[]{ 25, 40,  50, 50};
      paramName = new String[]{ "Angle", "Relative Length", "Angle 2", "Relative length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,5, 0,2,3, 1},
            };
      info = "a=c\nb=e\nd=f\nB+C+D=360\n(A+E+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      // tile is parallellogram with identical triangles added to opposite sides
      double ln2 =  1.2 * paramValues[1]/100.; //length of those two parallel diagonals
      double ln1 =  1.2 - ln2; //width between diagonals
      double ln4 = ln2/2 * paramValues[3]/100.; //distance from middle of parallelogram side to point
      double t = ln1*Math.tan( paramValues[0]* DEG2RAD); // length of other two sides
      double c = ln4*Math.cos( paramValues[2]* DEG2RAD); // length of other two sides
      double s = ln4*Math.sin( paramValues[2]* DEG2RAD); // length of other two sides

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln1,  t);
      baseTile.setPoint(2,ln1+c, t + ln2/2 -s);
      baseTile.setPoint(3, ln1,  t+ln2);
      baseTile.setPoint(4,   0,  ln2);
      baseTile.setPoint(5,  -c,  ln2/2-s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[0].getX(5);
      offsets[1] = tiles[1].getY(3)-tiles[0].getY(5);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(0);
   }
}
