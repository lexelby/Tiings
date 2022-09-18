package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_172
   extends TilingType
{
   public TilingTypeNC5_172(){
      super( "NC5-172", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 50};
      paramName = new String[]{ "Aspect", "Indent"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 1,0, 0,0,4, 1},
            {1, 0,4, 2,4,0, 1},
      };
      info = "a=b+d\ne=2c\nB=D\nD=E\nC+D=360\n(A+2E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 2.0;
      double w = lnt * getParam(paramValues,0)/100;
      double h = lnt - w;
      double lne = Math.sqrt(w*w/4+h*h);
      double lnb = w/3;
      double lnc = lne * getParam(paramValues,1)/150;
      double lna = lne - lnc;
      double dy = lnb * h/lne;
      double dx = lnb * w/2/lne;

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lna, 0 );
      baseTile.setPoint(2,  lna - dx, dy);
      baseTile.setPoint(3,  lne - dx, dy);
      baseTile.setPoint(4,  lne - dx*3, dy*3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[3].getX(1)-tiles[1].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[1].getY(0);
   }
}
