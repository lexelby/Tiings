package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bg1
   extends TilingType
{
   public TilingTypeN5_01bg1(){
      super( "N5-1bg1", 5, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{110};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {1, 3,2, 0,1,2, 0},
            {0, 1,2, 1,2,1, 0},
            {1, 0,1, 2,3,2, 0},
            {0, 1,2, 3,2,1, 0},
            {2, 1,2, 3,3,2, 0},
      };
      info = "a=b\nc=a+e\nd=2e\nA=B\nB+C=180\nC+D=180\n(E=2B)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .8;

      double a = getParam(paramValues, 0);
      double c = Math.cos(a * DEG2RAD);
      double f = 1-2*c;
      double s = Math.sqrt(1-c*c);
      
      ln1 /= (1+f);
      double ln2 = ln1*f;
      double ln3 = ln1 + ln2/2;

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1,  ln1,  0);
      baseTile.setPoint(2, ln1-ln3*c, ln3*s);
      baseTile.setPoint(3, ln1-ln2-ln3*c, ln3*s);
      baseTile.setPoint(4, ln1*c,ln1*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[5].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(0)-tiles[0].getY(0);
   }
}
