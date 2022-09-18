package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01z1
   extends TilingType
{
   public TilingTypeN5_01z1(){
      super( "N5-1z1", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{120};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,3,4, 0},
            {0, 1,0, 0,3,2, 1},
            {1, 4,3, 0,2,1, 1},
      };
      info = "c=d=e\nb=a+c\nB+C=180\nA=D\n(A+B+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double b = getParam(paramValues,0);
      double d = 180-b/2;
      double x = (d-b)/2;
      double y = 180-x-b;
      double ln1 = .6;
      //Math.sin(x*DEG2RAD)/ln2 = Math.sin(y*DEG2RAD)/ln1;
      double ln2 = Math.sin(x*DEG2RAD)*ln1 / Math.sin(y*DEG2RAD);
      double ln3 = ln1 + ln2;
      
      double x2 = ln3 - ln1 * Math.cos(b*DEG2RAD);
      double y2 =       ln1 * Math.sin(b*DEG2RAD);
      double x4 =       ln2 * Math.cos(d*DEG2RAD);
      double y4 =       ln2 * Math.sin(d*DEG2RAD);
      
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, ln3,   0);
      baseTile.setPoint(2,  x2,  y2);
      baseTile.setPoint(3,x2-ln1, y2);
      baseTile.setPoint(4,  x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}
