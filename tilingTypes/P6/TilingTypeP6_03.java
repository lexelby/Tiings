package tilingTypes.P6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP6_03
   extends TilingType
{
   public TilingTypeP6_03(){
      super( "P6-3&7", 6, SymmetryType.p2 );

      paramMin = new int[]{-90,  0,-180,  0,-180,  0};
      paramMax = new int[]{ 90,100, 180,500, 180,500};
      paramDef = new int[]{ 20, 40,  20, 58,  60, 50};
      paramName = new String[]{ "Angle", "Relative Length", "Angle 2", "Relative length 2", "Angle 3", "Relative length 3" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            };
      info = "b=e\nB+C+D=360\n(A+E+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      // tile is parallellogram with identical triangles added to opposite sides
      double ln2 =  1.2 * paramValues[1]/100.; //length of those two parallel diagonals
      double ln1 =  1.2 - ln2; //width between diagonals
      double t = ln1*Math.tan( paramValues[0]* DEG2RAD); // length of other two sides

      double ln4 = ln2/2 * paramValues[3]/100.; //distance from middle of parallelogram side to point
      double ln5 = ln2/2 * paramValues[5]/100.; //distance from middle of parallelogram side to point

      double x2 = ln1 + ln4 * Math.cos( paramValues[2] * DEG2RAD);
      double y2 = t+ln2/2 - ln4 * Math.sin( paramValues[2] * DEG2RAD);
      double x5 = -ln5 * Math.cos(  paramValues[4] * DEG2RAD);
      double y5 = ln2/2 - ln5 * Math.sin( paramValues[4] * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln1,  t);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3, ln1, t+ln2);
      baseTile.setPoint(4,   0,ln2);
      baseTile.setPoint(5,  x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(5)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(5)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(0);
   }
}
