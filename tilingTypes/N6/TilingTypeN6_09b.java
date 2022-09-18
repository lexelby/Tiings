package tilingTypes.N6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN6_09b
   extends TilingType
{
   public TilingTypeN6_09b(){
      super( "N6-9b", 6, SymmetryType.p2);

      paramMin = new int[]{-89,  0,-89};
      paramMax = new int[]{ 89,100, 89};
      paramDef = new int[]{ 25, 80, 20};
      paramName = new String[]{ "Angle", "Relative Length", "Angle 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,4, 0,1,2, 0},
            {1, 5,0, 1,1,2, 1},
      };
      info = "a=c=d=f\nb=e\nC=F\nB+C+D=360\n(A+E+F=360)";
   }

   public void recalcBase(double[] paramValues) {

      // tile is parallellogram with isosceles triangles added.
      double ln2 =  1.2 * paramValues[1]/100.; //length of those two parallel diagonals
      double ln1 =  1.2 - ln2; //width between diagonals
      double t = ln1*Math.tan( paramValues[0]* DEG2RAD); 

      double ln4 = ln2/2 * Math.tan( paramValues[2]* DEG2RAD); // length of triangle1 sides

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln1,  t);
      baseTile.setPoint(2,ln1+ln4, t + ln2/2);
      baseTile.setPoint(3, ln1,  t+ln2);
      baseTile.setPoint(4,   0,  ln2);
      baseTile.setPoint(5,-ln4,  ln2/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[0].getX(5);
      offsets[1] = tiles[2].getY(1)-tiles[0].getY(5);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(0);
   }
}
