package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_192
   extends TilingType
{
   public TilingTypeNC5_192(){
      super( "NC5-192", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{110, 60};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,0, 1},
            {1, 1,0, 1,0,1, 1},
            {0, 1,0, 2,2,1, 0},
      };
      info = "a=e\nb=d\nC=D\nB+C=360\n(A+D+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double a = getParam(paramValues,0);
      double lne = lna * getParam(paramValues,1)/200;
      double lnb = lna - lne;
      double lnd = lnb - lne;
      
      double c = Math.cos( a * DEG2RAD);
      double s = Math.sin( a * DEG2RAD);
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna + lnb*c, lnb*s);
      baseTile.setPoint(3, lne*c+ lnd, lne*s);
      baseTile.setPoint(4, lne*c, lne*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[0].getX(2)-tiles[3].getX(3);
      offsets[3] = tiles[0].getY(2)-tiles[3].getY(3);
   }
}
