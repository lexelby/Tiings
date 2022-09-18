package tilingTypes.P6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP6_06
   extends TilingType
{
   public TilingTypeP6_06(){
      super( "P6-6&11: Hexagon triplets", 6, SymmetryType.p3 );

      paramMin = new int[]{ -90,  0};
      paramMax = new int[]{  90,100};
      paramDef = new int[]{  10, 80};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,2,1, 0},
            {0, 0,1, 1,2,1, 0},
            };
      info = "a=f\nb=c\nd=e\nB=120\nD=120\nF=120\n(A+C+E=360)";
   }

   public void recalcBase(double[] paramValues) {

      // tile is general triangle with 30-120-30 triangles added on all sides.
      double ln2 = 1.5*getParam( paramValues,1)/100.; //distance from middle of triangle side to third point
      double ln1 = 1.5-ln2;
      double f = Math.sqrt(3)/6; // relative height of a 30-120-30 triangle

      double x4 = ln1/2 - ln2 * Math.sin( paramValues[0] * DEG2RAD);
      double y4 = ln2 * Math.cos( paramValues[0] * DEG2RAD);
      double x3 = ln1/2 + x4/2 + f*y4;
      double y3 = ln1*f + y4/2 - f*x4;
      double x5 = x4/2 - f*y4;
      double y5 = y4/2 + f*x4;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,ln1/2, -f*ln1);
      baseTile.setPoint(2, ln1,  0);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
      baseTile.setPoint(5,  x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(5)-tiles[0].getX(5);
      offsets[1] = tiles[1].getY(5)-tiles[0].getY(5);
      offsets[2] = tiles[2].getX(5)-tiles[0].getX(5);
      offsets[3] = tiles[2].getY(5)-tiles[0].getY(5);
   }
}