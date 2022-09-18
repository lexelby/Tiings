package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_146
   extends TilingType
{
   public TilingTypeNC5_146(){
      super( "NC5-146", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,4, 0},
            {0, 4,3, 0,0,1, 0},
            {0, 2,1, 2,1,2, 0},
      };
      info = "b=e=c+d\nD=E\nB+D=180\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 0.8;
      double lna = lnt * getParam(paramValues,0)/100;
      double lne = lnt - lna;
      
      double lnbd = lna + lne;
      
      double c1 = 4*lna;
      double c2 = 2*(lnbd+lne);
      double c3 = -lna-lnbd;
      double c = (-c2 + Math.sqrt(c2*c2-4*c1*c3))/2/c1;
      double s = Math.sqrt(1-c*c);
      
      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnbd, 0);
      baseTile.setPoint(2,  lnbd+c*lna, s*lna);
      baseTile.setPoint(3,  lnbd+c*lna+lne, s*lna);
      baseTile.setPoint(4,  lnbd+lne+c*(lna-lnbd), s*(lna+lnbd));
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[0].getX(2);
      offsets[1] = tiles[1].getY(3)-tiles[0].getY(2);
      offsets[2] = tiles[0].getX(3)-tiles[2].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[2].getY(0);
   }
}
