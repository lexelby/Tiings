package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01m
   extends TilingType
{
   public TilingTypeN5_01m(){
      super( "N5-1m", 5, SymmetryType.pgg );

      paramMin = new int[]{ 90,  0,   0,  0};
      paramMax = new int[]{180,100, 100,180};
      paramDef = new int[]{110, 50,  60,100};
      paramName = new String[]{ "Angle 1", "Aspect", "Side split", "Angle 2"};
      // 0=ori, 1=scale=horiz width,  2=angle of parallel sides, 3=hor/vert ratio, 4=parside split, 5=dist

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,3,2, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 2,3, 2,3,2, 0},
            
            {0, 1,2, 0,0,1, 1},
            {1, 2,3, 4,3,2, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 2,3, 6,3,2, 1},
            };
      info = "b=c+e\nC+D=180\n(A+B+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double c1 = Math.cos( paramValues[0] * DEG2RAD );
      double s1 = Math.sin( paramValues[0] * DEG2RAD );
      double c2 = Math.cos( paramValues[3] * DEG2RAD );
      double s2 = Math.sin( paramValues[3] * DEG2RAD );
      double ln1 = 1.2*getParam( paramValues,1)/100.; //vertical side
      double ln2 = 1.2-ln1;  // diagonal sides
      double ln3 = ln2*getParam( paramValues,2)/100.; //side split
      double ln4 = ln2-ln3;

      double x1 = ln2 * s1;
      double y1 = ln2 * c1;
      double x2 = x1 + ln3 * s1;
      double y2 = y1 - ln3 * c1;
      double x4 = ln1 * c2;
      double y4 = ln1 * s2;
      double x3 = x4 + ln4 * s1;
      double y3 = y4 - ln4 * c1;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}
