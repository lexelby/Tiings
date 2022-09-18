package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_194
   extends TilingType
{
   public TilingTypeNC5_194(){
      super( "NC5-194", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 90,100};
      paramDef = new int[]{ 40, 40};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 3,2, 1,2,3, 1},
            {0, 0,1, 2,0,1, 0},
      };
      info = "e=2c\nB=90\nD+E=180\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 1.4;
      double a = getParam(paramValues,0);
      double lnd = lna * getParam(paramValues,1)/100;

      double c = Math.cos( a * DEG2RAD);
      double s = Math.sin( a * DEG2RAD);
      double lnb = (lna - lnd)*c;
      double lnc = (lna - lnd)*s/3;
      double lne = 2*lnc;
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, lnb, lnc);
      baseTile.setPoint(3, lna*c, lna*s-lne);
      baseTile.setPoint(4, lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[3].getX(4);
      offsets[3] = tiles[0].getY(3)-tiles[3].getY(4);
   }
}
